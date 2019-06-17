data = open('Languages.txt')
Lan = []
for i in data:
    Lan.append(i.strip('\n'))
print(Lan)