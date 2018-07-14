count = input()
count_list = list(count.replace(' ',''))

m_list=[]
i=0

while True:
    if i < int(count_list[0]):
        count = input()
        m_list.append(''.join(count.split()))
    else :
        break
    i+=1
num_count = 0
for i in range( len(m_list) ):

    for j in range(len(m_list[i])):
        rows=0
        if rows < int(count_list[1]):

            for k in range(len(m_list[i+1])):

                if m_list[i][j+1] ==m_list[i+1][k+1]:
                    num_count+=1
                    break
        else:
            break
print(num_count)
