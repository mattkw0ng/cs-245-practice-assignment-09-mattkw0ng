public class BinaryHeap{
    private int size = 0;
    private int max = 10;
    private int[] data = new int[10];


    void add(int item){
        if(size+1==max){
            grow_array();
        }
        data[size++] = item;
        int child = size-1;
        int parent = (child-1)/2;
        while (parent>=0 && data[parent] > data[child]){
            swap(parent,child);
            child = parent;
            parent = (child-1)/2;
        }
    }

    int remove(){
        /*
        if(size==0){
            throw new Exception();
        }
        */
        int removed = data[0];
        data[0] = data[--size];
        sift_down(0);
        return removed;
    }

    void sift_down(int pos){
        int child = pos*2 +1; //for the left child
        if(child>=size){
            return;
        }
        if(child+1<size && data[child] > data[child+1]){ //selects the highest priority child
            child++;
        }
        if(data[pos]>data[child]){
            swap(pos,child);
            sift_down(child);
        }
    }


    void swap(int var1, int var2){
        int temp = data[var1];
        data[var1] = data[var2];
        data[var2] = temp;
    }

    void grow_array(){
        max = max*2; //updates the max size of the array
        int[] grown = new int[max];
        for(int i = 0 ; i<size ; i++){
            grown[i] = data[i];
        }
        data = grown;
    }

}