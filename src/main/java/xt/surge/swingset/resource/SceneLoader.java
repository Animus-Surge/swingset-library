package xt.surge.swingset.resource;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import xt.surge.swingset.components.*;
import xt.surge.swingset.components.canvas.*;
import xt.surge.swingset.components.physics.*;
import xt.surge.swingset.components.ui.*;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.util.Logger;

/**
 * The SceneLoader class handles all loading of scene (*.swsc or files in xml format) files for use in the game. Scene files
 * use XML (Extensible Markup Language) to define all scene nodes and resources used. 
 * 
 * <strong>NOTE</strong>: currently unimplemented
 * 
 * @author Surge
 * @version 1.0
 */
@SuppressWarnings("unused")
public class SceneLoader {
    
    /**
     * Load a scene from the specified path.<br><br>
     * This method scans the scene file and parses its XML contents to a Node tree.
     * @param path The path of the scene file. Can either begin with the <code>resource:</code> prefix or a direct filepath.
     * @return The node tree of the scene
     */
    public static Scene loadScene(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder docbuilder = factory.newDocumentBuilder();
            Document doc = docbuilder.parse(new File(path));

            Node rootNode;

            doc.getDocumentElement().normalize();
            if(doc.getDocumentElement().getNodeName() == "scene") {

                String sceneName = doc.getDocumentElement().getAttribute("name");

                loadResources((Element)doc.getDocumentElement().getFirstChild());
                Element root = (Element)doc.getDocumentElement().getLastChild();
                
                switch(root.getAttribute("class")) {
                    case "Node": rootNode = Node.fromElement(root); break;
                    case "Node2D": rootNode = Node2D.fromElement(root); break;
                    case "Rectangle": rootNode = Rectangle.fromElement(root); break;
                    case "RectColor": rootNode = RectColor.fromElement(root); break;
                    //TODO: add more nodes
                    default: rootNode = null; break;
                }

                if(rootNode == null) return null;

                checkChildren(rootNode, root);
            } else {
                Constants.RESLGR.log("Specified XML document: " + path + " does not contain a <scene> element.", Logger.ERROR);
            }
        } catch(Exception e) {
            Constants.RESLGR.logException(e, false, false);
        }

        return null;
    }

    /**
     * This function checks children of the specified element and adds them as child of root.
     * 
     * @param root The root node to add children to
     * @param element The element to check for child nodes
     */
    public static void checkChildren(Node root, Element element) {
        NodeList children = element.getChildNodes();

        for(int i = 0; i < children.getLength(); i++) {
            Element child = (Element)children.item(i);
            String nodeClass = child.getAttribute("class");
            if(nodeClass != "") {
                Node cnode;
                switch(nodeClass) {
                    case "Node": cnode = Node.fromElement(child); break;
                    case "Node2D": cnode = Node2D.fromElement(child); break;
                    case "Rectangle": cnode = Rectangle.fromElement(child); break;
                    case "RectColor": cnode = RectColor.fromElement(child); break;
                    //TODO: add more nodes
                    default: cnode = null; break;
                }
                if(cnode != null) root.addChild(cnode);

                checkChildren(cnode, child); //Check the children of the child node for any other nodes
            } else {
                return;
            }
        }
    }

    public static void loadResources(Element resourcesRoot) {
        //TODO
    }

}
