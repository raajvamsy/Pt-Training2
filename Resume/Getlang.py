from urllib import request
from bs4 import BeautifulSoup
data = request.urlopen("https://en.wikipedia.org/wiki/List_of_programming_languages").read()
soup = BeautifulSoup(data,'html.parser')
div= soup.find('div',attrs={'class':'mw-parser-output'})
lang = []
l = ['Alphabetical', 'Categorical', 'Chronological', 'Generational','v', 't', 'e', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z ', 'See also']
for i in div.find_all('li'):
    if i.text not in l:
        lang.append(i.text)
    if i.text == 'Z++':
        break

print(lang)