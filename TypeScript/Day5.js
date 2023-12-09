"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Input_1 = require("./Input");
var Day5 = /** @class */ (function () {
    function Day5() {
        this.url = "../inputs/input5.txt";
        this.maps = [];
        this.locs = [];
        this.run();
    }
    Day5.prototype.run = function () {
        var input = new Input_1.Input();
        this.document = input.getLines(this.url);
        var seeds = this.document[0].split(' ').slice(1).map(Number);
        this.createMaps();
        for (var _i = 0, seeds_1 = seeds; _i < seeds_1.length; _i++) {
            var seed = seeds_1[_i];
            var loc = this.getLoc(seed);
            this.locs.push(loc);
        }
        console.log(Math.min.apply(Math, this.locs));
    };
    Day5.prototype.getLoc = function (seed) {
        var total = seed;
        for (var _i = 0, _a = this.maps; _i < _a.length; _i++) {
            var mapping = _a[_i];
            for (var _b = 0, mapping_1 = mapping; _b < mapping_1.length; _b++) {
                var _c = mapping_1[_b], dstStart = _c[0], srcStart = _c[1], rangeLen = _c[2];
                if (srcStart <= total && total < srcStart + rangeLen) {
                    total = dstStart + (total - srcStart);
                    break;
                }
            }
        }
        return total;
    };
    Day5.prototype.createMaps = function () {
        var i = 2;
        while (i < this.document.length) {
            this.maps.push([]);
            i += 1;
            while (i < this.document.length && this.document[i] !== '') {
                var _a = this.document[i].split(' ').map(Number), dstStart = _a[0], srcStart = _a[1], rangeLen = _a[2];
                this.maps[this.maps.length - 1].push([dstStart, srcStart, rangeLen]);
                i += 1;
            }
            i += 1;
        }
    };
    return Day5;
}());
var app = new Day5();
