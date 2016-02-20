public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if(nums == null || nums.length == 0 ) return res;
        if(nums.length < 2) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 1)  {
                end = nums[i-1];
                if(start == end) res.add(Integer.toString(start));
                else res.add(start + "->" + end);
                start = nums[i];
                end = start;
            }
            else end = nums[i];
        }
        if(start == end) res.add(Integer.toString(start));
        else res.add(start + "->" + end);
        return res;
    }


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums==null){
            return null;
        }
        List<String> res = new ArrayList<String>();
        int length=nums.length;
        if(length==0){
            return res;
        }
        int rangeMin=nums[0];
        int rangeMax=nums[0];
        String comb = null;
        
        if(length==1){
            comb=String.valueOf(nums[0]);
            res.add(comb);
        }
        else{
            for(int i=0;i<length-1;i++){
                if(nums[i+1]==nums[i]+1){
                    rangeMax=nums[i+1];
                }
                else{
                    if(rangeMin==rangeMax){
                        comb=String.valueOf(rangeMin);
                        res.add(comb);
                    }
                    else{
                        comb=rangeMin+"->"+rangeMax;
                        res.add(comb);
                    }
                    rangeMin=nums[i+1];
                    rangeMax=nums[i+1];
                }
                if(i+1==length-1){
                    if(rangeMin!=rangeMax){
                        comb=rangeMin+"->"+rangeMax;
                        res.add(comb);
                    }
                     else{
                        comb=String.valueOf(rangeMin);
                        res.add(comb);
                     }   
                    }
            }
            
        }
        return res;
    }
}