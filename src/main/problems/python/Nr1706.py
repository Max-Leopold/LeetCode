class Solution(object):
    def findBall(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[int]
        """
        startingPoint = 0
        isOut = len(grid)
        outputs = []

        while startingPoint < len(grid[0]):
            ballPos = [startingPoint, 0]
            aboveSlope = True

            while True:
                slope = grid[ballPos[1]][ballPos[0]]
                if aboveSlope:
                    if slope == 1:
                        ballPos[0] += 1
                        if ballPos[0] >= len(grid[0]) or ballPos[0] < 0:
                            outputs.append(-1)
                            break
                        nextSlope = grid[ballPos[1]][ballPos[0]]
                        if nextSlope == -1:
                            outputs.append(-1)
                            break
                    elif slope == -1:
                        ballPos[0] -= 1
                        if ballPos[0] >= len(grid[0]) or ballPos[0] < 0:
                            outputs.append(-1)
                            break
                        nextSlope = grid[ballPos[1]][ballPos[0]]
                        if nextSlope == 1:
                            outputs.append(-1)
                            break

                    aboveSlope = False
                elif not aboveSlope:
                    ballPos[1] += 1
                    aboveSlope = True

                if ballPos[0] >= len(grid[0]) or ballPos[0] < 0:
                    outputs.append(-1)
                    break

                if ballPos[1] == isOut:
                    outputs.append(ballPos[0])
                    break

            startingPoint += 1

        return outputs


if __name__ == '__main__':
    sol = Solution()
    print(sol.findBall([
        [1, 1, 1, 1, 1, 1],
        [-1, -1, -1, -1, -1, -1],
        [1, 1, 1, 1, 1, 1],
        [-1, -1, -1, -1, -1, -1]
    ]))
