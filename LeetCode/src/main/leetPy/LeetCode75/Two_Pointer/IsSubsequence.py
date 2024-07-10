def isSubquence(s, t):
    """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """

    if len(s) > len(t):
        return False
    if len(s) == 0:
        return True
    c=0
    for i in range(len(t)):
        if c <= len(s) -1:
            if s[c] == t[i]:
                c += 1
    return len(s) == c


if __name__ == '__main__':
    s = "abc"
    t = "absdcwxa"
    print(isSubquence(s, t))