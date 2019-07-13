#include<iostream>
using namespace std;

void shift(int *a, int low, int high){
    int parent = low;
    int max_child = 2 * parent + 1;
    int temp = a[low];
    while(max_child <= high){
        if(max_child < high && a[max_child] < a[max_child + 1]){
            max_child += 1;
        }
        if(temp < a[max_child]){
            a[parent] = a[max_child];
            parent = max_child;
            max_child = 2 * parent + 1;
        }else{
            break;
        }
    }
    a[parent] = temp;
}

void heap_sort(int* a, int length){
    int start_index = length / 2 - 1;
    // set up heap
    for(int i = start_index; i >= 0; --i){
        shift(a, i, length - 1);
    }

    int temp = 0;
    // get the top element of heap
    for(int i = length - 1; i > 0; i--){
        temp = a[i];
        a[i] = a[0];
        a[0] = temp;
        shift(a, 0 , i - 1);
    }
}

void print(int *a, int length){
	for(int i = 0; i < length; i++){
		cout << a[i] << " ";
	}
}


int main(){
    int  a[] = {12, 3, 4, 45, 9, 78, 128};
    heap_sort(a, 7);
    print(a, 7);
	//getchar();
}


