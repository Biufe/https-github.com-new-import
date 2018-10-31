package sortTest;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {

        //冒泡排序，永远保证后一个数比前一个数大
        int[] arr = {5,2,4,1,9};
        int temp;
        for(int i = 0;i<arr.length;i++)
            for (int j = 1;j<arr.length;j++){
                if(arr[j-1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] =temp;
                }
        }
//        System.out.println(Arrays.toString(arr));

        //选择排序，保证每次循环选出最大得一个数
        int[] arr1 = {5,2,4,1,9};
        int temp1;
        for(int i = 0;i<arr1.length-1;i++)
            for (int j = i+1;j<arr1.length;j++){
                if(arr1[i]>arr1[j]){
                   temp1 = arr1[i];
                   arr1[i] = arr1[j];
                   arr1[j] = temp1;
                }

            }
//        System.out.println(Arrays.toString(arr1));


        int[] arr2 = {7,2,5,4,1};
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));

    }


    public static void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //  如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }


    public static void quickSort(int[] a,int left,int right){
       int i,j,t,temp;
       if(left>right)
           return ;

       temp = a[left];
       i = left;
       j = right;

       while(i!=j){
           while(a[j]<=temp&&i<j)//先从右边往左走
               j--;
           while(a[i]>=temp&&i<j)//再从左往右走
               i++;
           if(i<j){
               t = a[i];
               a[i] = a[j];
               a[j] = t;
           }
       }
        a[left]=a[i];//i==j
        a[i] = temp;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }
}

