class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int p1=Integer.MIN_VALUE;
        int p2=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            list.add(arr[i]);
        }
        if(list.contains(0))
        {
            List<Integer> l1= new ArrayList<>(list);
            int count=0;
            while(l1.contains(0) && count<2)
            {
                l1.remove((Integer)0);
                count++;
            }
            if(count==2)
            {
                Collections.sort(l1);
                System.out.println(l1);
                String str="";
                if(l1.get(1)<=2 && l1.get(0)<=2)
                {
                    return l1.get(1)+""+l1.get(0)+":00";
                }
                if(l1.get(0)==0 && l1.get(1)==0)
                {
                    return "00:00";
                } 
                if(l1.get(0)==1 && l1.get(1)<=9 && l1.get(1)>2)
                {
                    return l1.get(0)+""+l1.get(1)+":"+"0"+"0"; 
                }
                if(l1.get(0)==2 && l1.get(1)<=3)
                {
                    return l1.get(0)+""+l1.get(1)+":"+"0"+"0"; 
                }

                if(l1.get(0)==2 && l1.get(1)<=5 )
                {
                    return l1.get(0)+"0:"+l1.get(1)+"0";
                }
                if(l1.get(0)==2 && l1.get(1)>=5 )
                {
                    return l1.get(0)+"0:"+"0"+l1.get(1);
                }
                if(l1.get(1)<=1 && l1.get(0)<=1)
                {
                    return l1.get(1)+""+l1.get(0)+":00";
                }
                else if(l1.get(0)>5)
                {
                    return "0"+l1.get(1)+":0"+l1.get(0);
                }
                return "0"+l1.get(1)+":"+l1.get(0)+"0"; 
            }
        }
            for(int i=2;i>=0;i--)
            {
                if(list.contains(i))
                {
                    p1=i;// 2
                    list.remove((Integer)i);
                    break;
                }
            }
        int flag=0;
        if(p1==2)
        {
            for(int i=3;i>=0;i--)
            {
                if(list.contains(i))
                {
                    p2=i;
                    list.remove((Integer)i);
                    break;
                }
            }
        }
        else if(p1<=1)
        {
            for(int i=9;i>=0;i--)
            {
                if(list.contains(i))
                {
                    p2=i;
                    list.remove((Integer)i);
                    break;
                }
            }
        }
        if(p1==Integer.MIN_VALUE || p2==Integer.MIN_VALUE)
        {
            return "";
        }
        Collections.sort(list);
        String str="";
        if(list.get(0)==0)
        {
            if(list.get(1)<=5)
            {
                return p1+""+p2+":"+list.get(1)+""+list.get(0);
            }
            else if(list.get(1)>5)
            {
                return p1+""+p2+":"+list.get(0)+""+list.get(1);
            }
        }
        int dd1=list.get(0)+list.get(1)*10;
        int dd2=list.get(0)*10+list.get(1);
        if(dd1>=dd2 && dd1<=59)
        {
            str=dd1+"";
        }
        else if(dd2<dd1 && dd2<=59)
        {
            str=dd2+"";
        }
        else if(dd1>59 && dd2>59)
        {
            if(list.get(0)>5)
            {
                if(p2==0)
                {
                    return p2+""+list.get(1)+":"+p1+""+list.get(0);
                }
                else if(p1==0 && p2<=5)
                {
                    return p1+""+list.get(1)+":"+p2+""+list.get(0);
                }
                else if(p2==1)
                {
                    return p2+""+list.get(1)+":"+p1+""+list.get(0);
                }
                return "";
            }
            else if(p2==2 && p1>=0)
            {
                return "";
            }
            return "";
        }
        str=p1+""+p2+":"+str;
        return str;
    }
}