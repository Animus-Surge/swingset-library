package xt.surge.swingset.resource;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

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
        try {
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fact.newDocumentBuilder();
            Document sceneDoc = builder.parse(new File(path));

            Element sceneroot = sceneDoc.getDocumentElement();
            if(sceneroot.getNodeName().equals("scene")) {
                xt.surge.swingset.components.Node root = new xt.surge.swingset.components.Node();
                for(int i = 0; i < sceneroot.getChildNodes().getLength(); i++) {
                    org.w3c.dom.Node node = sceneroot.getChildNodes().item(i);

                    if(node.getNodeName().equals("resources") && node.getNodeType() == 1) {
                        loadResources((Element)node);
                    }
                    else if (node.getNodeName().equals("node") && node.getNodeType() == 1) {
                        Element elem = (Element) node;
                        root = new xt.surge.swingset.components.Node();
                        switch(elem.getAttribute("class")) {
                            case "Node":
                                root = xt.surge.swingset.components.Node.fromElement(elem);
                                break;
                            case "Node2D":
                                root = Node2D.fromElement(elem);
                                break;
                            case "Rectangle":
                                root = Rectangle.fromElement(elem);
                                break;
                            case "RectColor":
                                root = RectColor.fromElement(elem);
                                break;
                            case "Sprite":
                                root = Sprite.fromElement(elem);
                                break;
                            case "PhysicsBody":
                                break;
                            case "UIElement":
                                break;
                            
                            default:
                                break;
                        }
                        checkChildren(root, elem);

                        return new Scene(sceneroot.getAttribute("name"), root);
                    }
                }
            }
        } catch (Exception e) {
            Constants.RESLGR.logException(e, false, false);
        }
        return null; //TODO: make it return the current scene of the game
    }

    public static void checkChildren(xt.surge.swingset.components.Node root, Element elem) {
        NodeList children = elem.getChildNodes();
        for(int i = 0; i < children.getLength(); i++) {
            org.w3c.dom.Node child = children.item(i);

            if(child.getNodeName().equals("node") && child.getNodeType() == 1) {
                Element e = (Element) child;
                xt.surge.swingset.components.Node node = new xt.surge.swingset.components.Node();

                switch(e.getAttribute("class")) {
                    case "Node":
                        node = xt.surge.swingset.components.Node.fromElement(e);
                        break;
                    case "Node2D":
                        node = Node2D.fromElement(e);
                        break;
                    case "Rectangle":
                        node = Rectangle.fromElement(e);
                        break;
                    case "RectColor":
                        node = RectColor.fromElement(e);
                        break;
                    case "Sprite":
                        node = Sprite.fromElement(e);
                        break;
                    case "PhysicsBody":
                        break;
                    case "UIElement":
                        break;
                    
                    default:
                        break;
                }
                checkChildren(node, e);
                root.addChild(node);
            }
        }
    }    

    public static void loadResources(Element resourcesRoot) {
        //TODO
    }

}
