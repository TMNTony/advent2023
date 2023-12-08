namespace Advent2023;

public class Day7
{
    private string[] _lines = Array.Empty<string>();
    private readonly string _url = "../../../../../../inputs/input7.txt";

    public Day7()
    {
        Run();
    }

    private void Run()
    {
        var input = new Input();
        _lines = input.GetLines(_url);

        foreach (var line in _lines)
        {
            Console.WriteLine(line);
        }

        Console.WriteLine(GetScore());
    }

    private int GetScore()
    {
        var total = _lines.Length * 7;
        return total;
    }
}