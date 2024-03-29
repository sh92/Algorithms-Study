
int binarySearch(int[] a, int x) {
   int low = 0;
   int high = a.length -1;
   int mid;

   while(low<=high) {
      mid = (low + high)/2;
	  if(a[mid] < x){
	     low = mid + 1;
	  } else if(a[mid] > x) {
	     low = mid - 1;
	  } else {
	     return mid;
	  }
   }
   reutrn -1;
}

int binarySearchRecursive(int[]a, int x, int low, int  high) {
   if(low >high) return -1;

   int mid = (low + high)/2;
   if(a[mid] < x) { 
      return binarySearchRecursive(a,x,mid+1,high);
   }
   else if( a[mid] >x ) {
      return binarySearchRecursive(a,x, low, mid-1);
   }
   else{ 
      return mid;
   }
}
