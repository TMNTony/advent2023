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
        for (var _i = 0, _a = this.lines; _i < _a.length; _i++) {
            var line = _a[_i];
            console.log(line);
        }
    };
    return Day5;
}());
