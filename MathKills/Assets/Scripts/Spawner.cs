using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Spawner : MonoBehaviour {

	// Numbers arroy
	public GameObject player;
	public GameObject[] numbers;
	public GameObject instantiatedNumber;
	List<GameObject> instantiatedNumbers = new List<GameObject>();
	List<GameObject> numbersToRemove = new List<GameObject>();



	public void spawnNext() {
		// Choose a random index
		int i = Random.Range(0, numbers.Length);

		// Choose a random X position
		float spawnX = Random.Range(-2, 3);

		// Set the Y and Z positions
		float spawnY = 4.5f;
		float spawnZ = -2.0f;


		// Spawn number at Spawner's position (Spawner will always be above player by a constant distance)
		instantiatedNumber = (GameObject) Instantiate(numbers[i], new Vector3(spawnX, spawnY + player.transform.position.y, spawnZ), Quaternion.Euler(0, 0, Random.Range(0, 360)));
		// Add the instantiated number to a list
		instantiatedNumbers.Add(instantiatedNumber);
	}

	// Rescales all the number prefabs
	public void resizeNumbers(){
		foreach(GameObject number in numbers){
			number.transform.localScale = new Vector3 (1.8f, 1.8f, 1.8f);
		}
	}

	// Destroys an instantiated object
	public void destroy(GameObject obj) {
		Destroy (obj);
	}

	void Start() {
		// Resizes the numbers
		resizeNumbers ();
		// Spawn number when game begins and every 2 seconds
		InvokeRepeating("spawnNext", 0, 2);
	}
		
	void Update() {
		// Destroys instantiated numbers that are below the eraser
		// or too far off screen
		// TESTING - Currently destroys objects that are 4 lower than player
		// Solutions: Must make background screen taller or have camera more zoomed in
		foreach (GameObject number in instantiatedNumbers) {
			if (number.transform.position.y + 5 <= player.transform.position.y) {
				numbersToRemove.Add(number);
			}
		}

		foreach (GameObject number in numbersToRemove) {
			destroy(number);
			instantiatedNumbers.Remove(number);
		}
	}
}
