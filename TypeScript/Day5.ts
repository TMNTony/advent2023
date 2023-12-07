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
        console.log(this.getScore())
    }

    private getScore(): number {
        let total: number = 0;

        total = 5 * 7


        return total;
    }
}
const app = new Day5();
