给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null) return res;
        Arrays.sort(candidates);
        backTrack(candidates,target,0,new ArrayList<>(),new boolean[candidates.length]);
        return res;
    }
    private void backTrack(int[] arr,int target,int index,List<Integer> row,boolean[] isVisited){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&arr[i]==arr[i-1]&&!isVisited[i-1]){
                continue;
            }
            row.add(arr[i]);
            isVisited[i]=true;
            backTrack(arr,target-arr[i],i+1,row,isVisited);
            isVisited[i]=false;
            row.remove(row.size()-1);
        }
    }
}

给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list=new LinkedList<>();
        int[] fac=new int[n+1];
        fac[0]=1;
        for(int i=1;i<=n;i++){
            list.add(i);
            fac[i]=i*fac[i-1];
        }

        StringBuilder sb=new StringBuilder();
        k-=1;
        for(int i=n-1;i>=0;i--){
            int a=k/fac[i];
            sb.append(list.remove(a));
            k-=a*fac[i];
        }
        return new String(sb);
    }
}