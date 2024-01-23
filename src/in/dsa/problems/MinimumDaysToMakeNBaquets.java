package in.dsa.problems;

public class MinimumDaysToMakeNBaquets {
	
	private static boolean possible(int[] arr, int mid, int roses, int baquet) {
		
		int count = 0;
		int noOfBaquet = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] <= mid) {
				count++;
			}
			else {
				noOfBaquet = noOfBaquet + (count / roses);
				count = 0;
			}
		}
		
		noOfBaquet = noOfBaquet + (count / roses);
		
		if(noOfBaquet >= baquet) return true;
		
		return false;
	}
	
	
	public static int roseGarden(int[] arr, int roses, int baquet) {
		
		long val = roses * baquet;
		
		if(val > arr.length) return -1;
		
		int ans = -1;
		int minDay = Integer.MAX_VALUE;
		int maxDay = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			minDay = Math.min(minDay, arr[i]);
			maxDay = Math.max(maxDay, arr[i]);
		}
		
		
		int low = minDay;
		int high = maxDay;
		
		while(low <= high) {
			
			if(low > high) return -1;
			
			int mid = (low + high) / 2;  // 10
			
			if(possible(arr, mid, roses, baquet)) {
				ans = mid;
				high = mid - 1;
			}
			else low = mid + 1;
			
		}
		return ans;
	}

}
