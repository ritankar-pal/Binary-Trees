package in.dsa.problems;

public class LeastWeightToShipInDDays {
	
	private static int daysRequired(int[] weights, int capacity) {
		
		int days = 0;
		int load = 0;
		
		for(int i = 0; i < weights.length; i++) {
			
			if(load + weights[i] > capacity) {
				days++;
				load = weights[i];
			}
			else {
				load = load + weights[i];
			}
		}
		
		return days;
	}

	public static int leastWeightCapacity(int[] weights, int days) {

		int low = maxElem(weights);
		int high = sum(weights);
		int ans = 0;

		while(low <= high) {
			
			if(low > high) return -1;
			
			int mid = (low + high) / 2;
			
			if(daysRequired(weights, mid) <= days) {
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
			
		}
		
		return ans;
	}
	


	private static int sum(int[] weights) {
		
		int sum = 0;

		for(int i = 0; i < weights.length; i++) {
			 sum = sum + weights[i];
		}

		return sum;
	}


	private static int maxElem(int[] weights) {
		
		int max = weights[0];

		for(int i = 1; i < weights.length; i++) {
			if(weights[i] > max) max = weights[i];
		}

		return max;
	}
}
