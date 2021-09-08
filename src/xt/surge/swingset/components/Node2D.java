package xt.surge.swingset.components;

import xt.surge.swingset.structs.Transform;

/**
 * A Node2D is a node type that includes an x and a y coordinate. Regular Nodes aren't rendered and
 * can be used as containers for other nodes, like folders in a filesystem. This class aids in
 * adding offsets or something of the sort.
 * 
 * @author Surge
 * @version 1.0
 */
public class Node2D extends Node {

	/**
	 * The transform object of the node
	 */
	public Transform transform;

	/**
	 * Creates a new Node2D at the origin.
	 */
	public Node2D() {
		this.transform = new Transform();
		this.nodeName = "Node2D";
	}

	/**
	 * Creates a new Node2D at the origin with the specified name.
	 */
	public Node2D(String name) {
		this.transform = new Transform();
		this.nodeName = name;
	}

	/**
	 * Creates a new Node2D at the specified coordinates
	 */
	public Node2D(float x, float y) {
		this.transform = new Transform(x, y);
	}

	/**
	 * Creates a new Node2D at the specified coordinates with the specified name
	 */
	public Node2D(float x, float y, String name) {
		this.transform = new Transform(x, y);
		this.nodeName = name;
	}

}
