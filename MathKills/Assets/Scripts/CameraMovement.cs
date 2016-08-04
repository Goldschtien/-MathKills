using UnityEngine;
using System.Collections;

public class CameraMovement : MonoBehaviour {

	public Transform player;      // Reference the player's transform
	public Vector3 offset;      // Specify an offset vector
	
	// Update is called once per frame
	void Update () {
		// Set camera's position to player's position with offset
		// Moves camera up and down only
		transform.position = new Vector3 (offset.x, player.position.y + offset.y, player.position.z + offset.z);
	}
}
