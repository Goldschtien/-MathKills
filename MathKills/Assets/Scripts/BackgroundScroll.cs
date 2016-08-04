using UnityEngine;
using System.Collections;

public class BackgroundScroll : MonoBehaviour {

	public float scrollSpeed;

	void Update(){
		
		Vector3 offset = new Vector2 (0, GameObject.FindGameObjectWithTag("Player").transform.position.y * scrollSpeed);

		GetComponent<Renderer> ().material.mainTextureOffset = offset;
	}
}
