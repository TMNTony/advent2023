"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Input = void 0;
var fs = require("fs");
var Input = /** @class */ (function () {
    function Input() {
    }
    Input.prototype.getLines = function (url) {
        try {
            var file = fs.readFileSync(url, 'utf-8');
            return file.split("\n");
        }
        catch (e) {
            throw new Error(e);
        }
    };
    Input.prototype.getString = function (url) {
        try {
            return fs.readFileSync(url, 'utf-8').trim();
        }
        catch (e) {
            throw new Error(e);
        }
    };
    return Input;
}());
exports.Input = Input;
