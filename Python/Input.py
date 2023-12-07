class Input:
    @staticmethod
    def get_lines(url):
        try:
            with open(url, encoding="utf-8") as file:
                return file.read().splitlines()
        except Exception as e:
            raise RuntimeError(f"Error reading file at {url}: {str(e)}")
