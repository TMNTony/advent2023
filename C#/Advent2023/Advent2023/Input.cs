namespace Advent2023;

public class Input
{
    public string[] GetLines(string url)
    {
        try
        {
            string file = File.ReadAllText(url, System.Text.Encoding.UTF8);
            return file.Split(new[] { '\n', '\r' }, StringSplitOptions.RemoveEmptyEntries);

        }
        catch (Exception e)
        {
            throw new Exception("Error loading files");
        }
    }
}