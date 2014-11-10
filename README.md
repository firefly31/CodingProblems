CodingProblems
==============

Pick top k most frequently occuring words from a huge string in O(n)


String : This is first String to test.
 Top 0 words:

String : Here is another test. This, has: more punctuations!! You like this, don't you??
 Top 2 words:
  this
  you

String : Programmer : (Neha Heera) Version: 10
 Top 4 words:
  10
  heera
  neha
  programmer

String : Jupiter and Venus hung like grapes in the evening sky, frozen and untwinkling, You could have reached and up and picked them. And the trout swam. Snow muffled the world, silenced the dog, silenced the wind... The man said, I can show you the trout. He was glad of the company. He reached into their tiny pool, rescued a dozen, one by one,sorting and choosing, dividing the sheep from the goats of them. And this was the miracle of the fishes,that they were beautiful. Even when clubbed and gutted, insides glittering like jewels. See this? he said, the trout heartpulsed like a ruby in his hand. The kids love this.  He put it down, and it kept beating. The kids, they go wild for it.He said, we feed the guts to the pigs. They're pets now, They won't be killed. See? We saw, huge as horses they loomed on the side of the hill.
 Top 6 words:
  the
  and
  he
  they
  of
  it



Parsing the characters = O(n) 
Say we found ‘m’ number of words. m will always be < n. In worst case, when all the words are single character, m = n/2. In best case, when the entire string is only one word, m = 1.
To find top most element from Map of size m = O(m)
To find second top most element from Map of size m = O(m-1)
To find top most ‘k’ elements from Map of size m 
= O(m * k - (1 + 2 + … +k)) 
approx = O(m * k)
= O((n/j) * k) (where m = n / j)

Top parse characters + Find topmost k elements =
O(n + (n/j) * k)

If the value of k is small compared to the huge input string n, the complexity will be ~= O(n + (n/j)
since n/j <= n, complexity ~= O(n).
