package leetcode.alice.array;
class PowXn {
         
    public double myPow(double x, int n){
     double result = fastPow(x,n);
      return n < 0 ? 1/result : result;
    }
    
    public double fastPow(double x, int n){
    
        if(n == 0){
          return 1d;
        }
        
        double half = fastPow(x, n/2);
        

        if(n % 2 == 0){
          return half * half;
        }else{
          return half * half * x;
        }
  }
}