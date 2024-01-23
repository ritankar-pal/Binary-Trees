package in.dsa.problems;

public class SmallestDivisor {
	
	private static int maxElem(int[] arr) {
		
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i];
		}
		
		return max;
	}
	
	
	private static int sumByD(int[] arr, int mid, int limit) {
		
		int ans = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			ans = (int) (ans + Math.ceil(arr[i] / mid));
		}
		
		return ans;
	}
	
	
	public static int smallestDiv(int[] arr, int limit) {
		
		int low = 1;
		int high = maxElem(arr);
		
		int ans = -1;
		
		while(low <= high) {
			
			if(low > high) return ans;
			
			int mid = ( low + high ) / 2;
			
			if(sumByD(arr, mid, limit) <= limit){
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
		}
		
		return ans;
	}
}
