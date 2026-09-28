w, h = 15, 15
grid = [[False for i in range(w)] for i in range(h)]
dic = {False: ".", True: "X"}
import os

## GLIDER SETUP {
grid[0][1] = True
grid[1][2] = True
grid[2][0] = True
grid[2][1] = True
grid[2][2] = True
### }
def checker(cell_x, cell_y):
    if cell_x < 0 or cell_y < 0 or cell_x >= w or cell_y >= h:
        return 0
    if grid[cell_y][cell_x]:
        return 1
    else:
        return 0


def check(cell_x, cell_y):
    global grid, new
    if grid[cell_y][cell_x]:
        val = checker(cell_x+1, cell_y) + checker(cell_x-1, cell_y) + checker(cell_x, cell_y+1) + checker(cell_x, cell_y-1) + checker(cell_x+1, cell_y+1) + checker(cell_x+1, cell_y-1) + checker(cell_x-1, cell_y+1) + checker(cell_x-1, cell_y-1)
        if val == 2 or val == 3:
            new[cell_y][cell_x] = True
    else:
        val = checker(cell_x+1, cell_y) + checker(cell_x-1, cell_y) + checker(cell_x, cell_y+1) + checker(cell_x, cell_y-1) + checker(cell_x+1, cell_y+1) + checker(cell_x+1, cell_y-1) + checker(cell_x-1, cell_y+1) + checker(cell_x-1, cell_y-1)
        if val == 3:
            new[cell_y][cell_x] = True

def ppprint(g):
    for r in g:
        print(" ".join(map(lambda x: dic[x], r)))
import time

ppprint(grid)

def not_end():
    global grid
    if sum([any(row) for row in grid]) == 0:
        return False
    return True
print()
while not_end():
    new = [[False for i in range(w)] for i in range(h)]
    for i in range(h):
        for j in range(w):
            check(j, i)
    grid[:] = new[:]
    time.sleep(0.05)
    ppprint(grid)
    print()
    #os.system("")
    #print(f"\x1b[2J\x1b[1;1H")



