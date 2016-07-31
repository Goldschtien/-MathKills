using UnityEngine;
using System.Collections;

public class Spawner : MonoBehaviour {

	// Numbers
	public GameObject[] numbers;

	public void spawnNext() {
		// Choose a random index
		int i = Random.Range(0, numbers.Length);
		float spawnX = Random.Range(-2, 3);
		float spawnY = 4.5f;
		float spawnZ = -2.0f;


		// Spawn number at Spawner with random Y position
		Instantiate(numbers[i], new Vector3(spawnX, spawnY, spawnZ), Quaternion.Euler(0, 0, Random.Range(0, 360)));
	}

	void Start() {
		// Spawn number when game begins and every 2 seconds
		InvokeRepeating("spawnNext", 0, 2);
	}
		
}
