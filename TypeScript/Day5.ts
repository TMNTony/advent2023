import {Input} from './Input'

class Day5 {
    lines: string[];
    url: string = "../inputs/input5.txt";

    constructor() {
        this.run();
    }

    private run() {
        const input = new Input();
        this.lines = input.getLines(this.url);

        for (const line of this.lines) {
            console.log(line)
        }
    }
}
