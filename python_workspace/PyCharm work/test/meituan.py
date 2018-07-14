n=input()
m_list=input().split(' ')
count=0
for j in range(len(m_list)):
    for k in range(len(m_list)):
        if j==k:
            continue
        elif int(m_list[j]+m_list[k])%7 ==0:
            count+=1
print(count)

