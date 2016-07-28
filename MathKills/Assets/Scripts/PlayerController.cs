using UnityEngine;
using System.Collections;
using UnityStandardAssets.CrossPlatformInput;

public class PlayerController : MonoBehaviour {
	private float _movex;
	public float moveSpeed;
	public float jump;
	private bool _facingRight;
	private Animator _animator;
	Rigidbody2D myBody;

	// Use this for initialization
	void Start () {
		myBody = this.GetComponent<Rigidbody2D> ();
		_facingRight = true;
		_animator = GetComponent<Animator> ();

	}
	
	// Update is called once per frame
	void FixedUpdate () {
		//checks horizontal movement of the joystick via CrossPlatformInputManger

		_movex = CrossPlatformInputManager.GetAxis ("Horizontal");
		bool move = CrossPlatformInputManager.GetAxis ("Horizontal") != 0;
		if (move) {

			myBody.velocity = new Vector2 (_movex * moveSpeed, myBody.velocity.y);
			_animator.SetFloat ("Speed", 1);

		}
		else if (!move)
		{
			_animator.SetFloat ("Speed", 0);

		}

		if (CrossPlatformInputManager.GetButtonDown ("Jump"))
		{

			myBody.velocity = new Vector2 (0, jump);
			//_animator.SetFloat ("Speed", 1);
		}
			
		Flip ();





	}
	//changes the way player is facing
	private void Flip()
	{
		_movex = CrossPlatformInputManager.GetAxis ("Horizontal");
		if (_movex < 0 && _facingRight) {	
			Vector3 facing = transform.localScale;
			facing.x *= -1;
			transform.localScale = facing;
			_facingRight = false;
		} else if (_movex > 0 && !_facingRight)
		{
			Vector3 facing = transform.localScale;
			facing.x *= -1;
			transform.localScale = facing;
			_facingRight = true;
		}
	}
}

	