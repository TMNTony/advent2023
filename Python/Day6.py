from Input import Input

class Day6:
    def __init__(self):
        self.lines = []
        self.url = "../inputs/input6.txt"
        self.run()

    def run(self):
        input = Input()
        self.lines = input.get_lines(self.url)
        print(self.get_score())

    def get_score(self):
        total = 5 * 9
        return total

app = Day6()