import re
from Input import Input


class Day6:
    def __init__(self):
        self.lines = []
        self.url = "../inputs/input6.txt"
        self.run()

    def run(self):
        total = 0
        text = Input()
        self.lines = text.get_lines(self.url)
        times = self.parse_line(self.lines[0])
        distances = self.parse_line(self.lines[1])
        for time in times:
            time = time * 3

        print(times)

    def get_score(self):
        total = 5
        multiplier = 7
        return total * multiplier

    def parse_line(self, line):
        parsed_line = re.findall(r'\b\d+\b', line)
        parsed_line = [int(num) for num in parsed_line]
        return parsed_line

Day6()
