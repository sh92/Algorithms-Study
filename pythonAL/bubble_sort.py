def bubble_sort(arr):
    for n in range(len(arr)-1, 0,-1):
        for k in range(n):
            if arr[k] > arr[k+1]:
                temp = arr[k]
                arr[k] = arr[k+1]
                arr[k+1] = temp

arr = [3,2,13,4,6,5,7,8,1,20]
bubble_sort(arr)

print arr
