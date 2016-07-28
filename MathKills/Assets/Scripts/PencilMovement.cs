using UnityEngine;
using System.Collections;

public class PencilMovement : MonoBehaviour {
	private float _automove;
	Rigidbody2D pencil;
	// Use this for initialization
	void Start () {
		pencil = this.GetComponent<Rigidbody2D> ();
		_automove = 1;
	
	}
	
	// Update is called once per frame
	void Update () {
		pencil.velocity = new Vector2 (_automove , pencil.velocity.y);


	}
		

	
}

