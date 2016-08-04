using UnityEngine;
using System.Collections;

public class Spawner : MonoBehaviour {

	// Numbers arroy
	public GameObject player;
	public GameObject[] numbers;

	public void spawnNext() {
		// Choose a random index
		int i = Random.Range(0, numbers.Length);

		// Choose a random X position
		float spawnX = Random.Range(-2, 3);

		// Set the Y and Z positions
		float spawnY = 4.5f;
		float spawnZ = -2.0f;


		// Spawn number at Spawner's position (Spawner will always be above player by a constant distance)
		Instantiate(numbers[i], new Vector3(spawnX, spawnY + player.transform.position.y, spawnZ), Quaternion.Euler(0, 0, Random.Range(0, 360)));
	}

	public void resizeNumbers(){
		// Loop through each number and rescale
		foreach(GameObject number in numbers){
			number.transform.localScale = new Vector3 (1.8f, 1.8f, 1.8f);
		}
	}

	void Start() {
		// Resizes the numbers
		resizeNumbers ();
		// Spawn number when game begins and every 2 seconds
		InvokeRepeating("spawnNext", 0, 2);
	}
		
}
