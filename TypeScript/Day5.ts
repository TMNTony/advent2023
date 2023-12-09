import {Input} from './Input';

class Day5 {
    document: string[];
    url: string = "../inputs/input5.txt";
    maps: number[][][] = [];
    locs: number[] = [];

    constructor() {
        this.run();
    }

    private run() {
        const input = new Input();
        this.document = input.getLines(this.url);
        const seeds = this.document[0].split(' ').slice(1).map(Number);

        this.createMaps();

        for (const seed of seeds) {
            const loc: number = this.getLoc(seed);
            this.locs.push(loc);
        }

        console.log(Math.min(...this.locs));
    }

    private getLoc(seed: number): number {
        let total = seed;

        for (const mapping of this.maps) {
            for (const [dstStart, srcStart, rangeLen] of mapping){
                if (srcStart <= total && total < srcStart + rangeLen) {
                    total = dstStart + (total - srcStart);
                    break;
                }
            }
        }
        return total;
    }

    private createMaps() {
        let i: number = 2;
        while (i < this.document.length) {
            this.maps.push([]);

            i += 1;
            while (i < this.document.length && this.document[i] !== '') {
                const [dstStart, srcStart, rangeLen] = this.document[i].split(' ').map(Number);
                this.maps[this.maps.length - 1].push([dstStart, srcStart, rangeLen]);
                i += 1;
            }

            i += 1;
        }
    }
}

const app = new Day5();

