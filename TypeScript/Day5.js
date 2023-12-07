"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Input_1 = require("./Input");
var Day5 = /** @class */ (function () {
    function Day5() {
        this.url = "../inputs/input5.txt";
        this.run();
    }
    Day5.prototype.run = function () {
        var input = new Input_1.Input();
        this.lines = input.getLines(this.url);
        console.log(this.getScore());
    };
    Day5.prototype.getScore = function () {
        var total = 0;
        total = 5 * 7;
        return total;
    };
    return Day5;
}());
var app = new Day5();
