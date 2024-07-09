def movingZeroes(nums):
    """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """

    idx = 0
    for i in nums:
        if i != 0:
            nums[idx] = i
            idx += 1

    while idx < len(nums):
        nums[idx] = 0
        idx += 1

    for i in nums:
        print(i)
    pass


if __name__ == '__main__':
    nums = [0,1,0,3,12]
    movingZeroes(nums)