def heap_sort(data):
    n = len(data)
    for i in range(n // 2 - 1, -1, -1):
        sift(data, i, n - 1)
    
    for i in range(n - 1, -1, -1):
        data[0], data[i] = data[i], data[0]
        print("第",n - i,"次取堆顶",array)
        sift(data, 0, i - 1)





def sift(data, low, high):
    parent = low
    max_child = 2 * low + 1
    temp = data[parent]
    while max_child < high: ## 孩子在堆里
        if max_child + 1 <= high and data[max_child] < data[max_child + 1]:  # 找到最大的孩子节点
            max_child = max_child + 1
        if data[max_child] > temp:   #  比较孩子节点和父节点的大小
            data[parent] = data[max_child]   #  将孩子节点的值更新到父节点上
            parent = max_child  # 孩子成为新父亲
            max_child = 2 * parent + 1  # 新孩子
        else:
            break
    data[parent] = temp  


if __name__ == "__main__":
    array = [12, 3, 4, 45, 9, 78, 128]
    n = len(array)
    print("建堆前",array)

    print()
    for i in range(n // 2 - 1, -1, -1):
        print("从",i,"位置处调整子树")
        sift(array, i, n - 1)
        print(array)
        print()

    heap_sort(array)
    print("排序完：",array)
