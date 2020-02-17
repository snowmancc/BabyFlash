insert into memberinfo(birthday, email, gender,imageUrl, name, password, token)
values('1990-10-13','123',0,"https://i.imgur.com/gVJtjox.jpg", '123', '123','');

insert into baby(birthday, gender, name, memberId)
values('2000-10-13',1, '123',1);

insert into mycard(url, time, note, memberId)
values('https://i.imgur.com/gVJtjox.jpg', '2000-10-13', 'MMmmMmm',1);

insert into issuetag(issueTagId, name)
values('M','健康');

insert into issuetag(issueTagId, name)
values('N','環境');

insert into issuetag(issueTagId, name)
values('O','穿著');

insert into issuetag(issueTagId, name)
values('P','飲食');

insert into issuetag(issueTagId, name)
values('Q','母乳');

insert into issuetag(issueTagId, name)
values('R','親子共讀');

insert into issuetag(issueTagId, name)
values('S','五感');

insert into issuetag(issueTagId, name)
values('T','兒童心理');

insert into issuetag(issueTagId, name)
values('U','教育');

insert into knowledgecard(knowledgeCardId,beginningPeriod, content, endPeriod, reference, title, url)
values(1,'3','父母每天可以排定幾個五到十五分鐘的時段，定時和不定時享受親子共讀。盡量讓活動在愉悅情境中進行，過程中父母記得投入情感、專注與喜悅。',
'36', '<親子共熬一鍋故事湯>', '每日親子共讀','https://www.books.com.tw/products/0010792768');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(2, '0','真實人類的語音跟電腦數位的聲音，對嬰兒的語言學習效果截然不同。真人賦予情感的聲調、肢體、表情、往返互動的語言環境，才是嬰幼兒腦部應該攝取的食物。',
'36', '<親子共熬一鍋故事湯>', '3C產品數位聲音無法取代真人互動','https://www.books.com.tw/products/0010792768');

insert into knowledgecard(knowledgeCardId,beginningPeriod, content, endPeriod, reference, title, url)
values(3,'0','以有簡單線條、色塊、形狀的厚紙板書為主。撕不壞的棉布書跟洗澡時可用的塑膠書都是不錯的選擇。',
'12', '<親子共熬一鍋故事湯>', '一歲以下寶寶的選書原則','https://www.books.com.tw/products/0010792768');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(4, '0','嬰兒會用耳朵請聽周圍的聲音，聽覺就是透過各式各樣的聲音而成長。接觸到有生命的聲音，如媽媽的聲音、風吹過的聲音、小鳥的啼叫聲...等等之後會讓孩子進入下一階段的音樂體驗。',
'12', '<在家也能華德福>', '用歌聲懷抱孩子','https://www.books.com.tw/products/0010785298');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(5, '0','在美國，每年有七百位五歲以下的小孩因為車禍死亡，六萬名兒童因車禍而受傷。這恐怖的數字可以因為使用汽車安全座椅而降低八十％的死亡率。',
'36', '<輕鬆當爸媽，孩子更健康>', '汽車安全座椅很重要！','https://www.books.com.tw/products/0010827007');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(6, '0','一般來說，如果每天有大三次便，尿布有沉甸甸的六包以上，就表示寶寶有吃飽了。',
'6', '<輕鬆當爸媽，孩子更健康>', '母乳媽媽如何知道寶寶有吃飽','https://www.books.com.tw/products/0010827007');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(7, '12','為了吸引兒童的注意，紅黃綠藍等色素，絕對是糖果餅乾的必備成分。然而根據2007年英國學者馬可教授所發表的一篇研究，發現食品添加物會引起孩童的過動解注意力不集中，兇手包括黃色4號、5號，及紅色6號、40號等。',
'36', '<輕鬆當爸媽，孩子更健康>', '食品添加物有害健康','https://www.books.com.tw/products/0010827007');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(8, '0','出生前三個月較常被擁抱的嬰兒，反而在一歲時較不黏人，而且更容易建立母嬰的「安全依附型」關係',
'24', '<安心做父母，在愛裡無懼>', '經常擁抱小孩','https://www.books.com.tw/products/0010816690');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(9, '0','善用法勒說話術：速度放慢、音調提高、自然回應。可以提高寶寶對語言的熟悉度，進而提升智力。',
'36', '<安心做父母，在愛裡無懼>', '跟寶寶說話技巧','https://www.books.com.tw/products/0010816690');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(10, '9','美國兒科醫學界呼籲，成人不要讓未滿一歲半的孩子看電視，認為合理的使用時間，是沒有妥協的零分鐘。孩子三歲之前，若能完全不看電視、平板、手機這是個理想的做法。',
'36', '<安心做父母，在愛裡無懼>', '一歲半以前，不讓孩子用3C','https://www.books.com.tw/products/0010816690');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(11, '9','寶寶一歲後，通常就可以均衡的吃副食品了。美國兒科醫生建議讓副食品成為一歲後寶寶營養的主要來源，而奶開始逐漸變成「副食品」的地位。',
'18', '<跟美國兒科醫師學育兒>', '一歲後副食品成主食','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(12, '6','在6~18個月這個年齡段，寶寶的心智還沒有成熟到會「耍心機」的程度，哭是他們最真實的表達，大人需要即時的回應，給寶寶足夠的安全感，這將有助於縮短分離焦慮的時間。',
'18', '<跟美國兒科醫師學育兒>', '正視寶寶情緒，給足夠安全感','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(13, '6','一歲以內寶寶不能吃的食物：蜂蜜；牛奶、豆奶；有窒息風險的小顆粒食物、高糖高鹽食物。',
'12', '<跟美國兒科醫師學育兒>', '週歲內飲食禁忌','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(14, '0','父母越淡定，越不當回事越好，慢慢地等寶寶探索夠就不會繼續了。如果大人不斷地阻止，反而強化了這種行為，寶寶會玩得更起勁。',
'12', '<跟美國兒科醫師學育兒>', '吃飯時人餐具或食物怎麼辦？','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(15, '12','如果超過15個月，大人就需要告訴寶寶，這樣做是不對的。說的時候要看著寶寶的眼睛，用堅定的語氣跟他說： 食物是用來吃的，餐具是用來裝食物的，都不能亂扔。',
'36', '<跟美國兒科醫師學育兒>', '吃飯時人餐具或食物怎麼辦？','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(16, '3','父母要有意識的建立一個安全、舒適的玩耍區域，放心大膽地讓寶寶去探索，不隨意打斷寶寶。',
'36', '<跟美國兒科醫師學育兒>', '如何保護和提高寶寶的專注力？','https://www.books.com.tw/products/0010775320');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(17, '9','藉由動手整理家中的環境，讓孩子體會到具有規律性的勞動，還可以學習愛惜地球的資源。當我們與孩子分享這些身體的勞動時，這是在示範、整合這些動作。',
'36', '<地球上的天堂>', '大人的勞動是孩子模仿的典範','https://www.books.com.tw/products/0010538492');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(18, '9','比起塞滿才藝班課程，讓孩子探索家中世界、一同整理家務，才是給孩子最豐富的資源。',
'36', '<地球上的天堂>', '家中的活動給孩子豐富的學習資源','https://www.books.com.tw/products/0010538492');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(19, '9','簡單的戶外活動，就是幼兒最佳的感官教育。到公園走走，或是到圖書館看書，對年幼的孩子已經足夠。',
'36', '<地球上的天堂>', '給幼兒簡單優質的活動足以。','https://www.books.com.tw/products/0010538492');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(20, '0','拔掉你的電話、關掉你的電視與電腦，讓我們控制時間，而不是被時間掌控。',
'36', '<地球上的天堂>', '沉靜心靈，用心陪伴孩子','https://www.books.com.tw/products/0010538492');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(21, '0','嗅覺與我們的記憶緊密的連結，對孩子來說，是相當重要的感官刺激。夜晚時，敞開你的窗戶，讓黑夜的氣息，進入家中。',
'36', '<地球上的天堂>', '嗅覺創造孩子美好記憶','https://www.books.com.tw/products/0010538492');

insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(22, '24','大約兩歲半的孩子就可以開始練習穿脫衣鞋，衣服要先練脫在練穿。首先可從最簡單的開襟式背心練起，在進階到外套及短袖。',
'36', '<跟著王宏哲，早期教育so easy！>', '練習穿脫衣鞋','https://www.books.com.tw/products/0010677449');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(23, '0','三個月的寶寶其視力已經達到成年的0.7～0.8 ，所以他們早已能看見更多、更遠，不要只給黑白閃卡，只要是顏色鮮艷的，或是對比色都能吸引他們的目光。',
'3', '<跟著王宏哲，早期教育so easy！>', '嬰兒視力','https://www.books.com.tw/products/0010677449');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(24, '0','寶寶兩個月起就應該常常抱直，讓他的眼睛可以有看遠、看近及上下的視野，並且與人互動。',
'3', '<跟著王宏哲，早期教育so easy！>', '抱值讓寶寶探索環境','https://www.books.com.tw/products/0010677449');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(25, '0','寶寶出生後，可以每天抱他出去曬曬太陽10~20分鐘；一歲之後應該要有30分鐘，兩歲之後至少要有50分鐘，晚上才不會日夜顛倒。',
'36', '<跟著王宏哲，早期教育so easy！>', '曬太陽幫助夜間睡眠','https://www.books.com.tw/products/0010677449');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(26, '12','孩子會走路時就要讓他們多走動，該跑時就要讓他們有機會、有場地多跑，父母千萬不要過度保護、緊張兮兮，才能鍛鍊孩子的黃金腦，同時也可以降低孩子動作發展遲緩的可能性。',
'36', '<跟著王宏哲，早期教育so easy！>', '讓孩子多動有助大腦發展','https://www.books.com.tw/products/0010677449');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(27, '0','哭是寶寶正常的溝通方式，保持情緒平穩才能有效安撫寶寶。',
'36', '<用愛教出快樂的孩子-0-6歲正向教養手冊>', '哭是寶寶溝通方式','https://health99.hpa.gov.tw/educZone/edu_detail.aspx?CatId=21983');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(28, '0','運用肢體語言同理寶寶的情緒，是協助寶寶學會情緒調節的第一步。',
'36', '<用愛教出快樂的孩子-0-6歲正向教養手冊>', '同理孩子情緒','https://health99.hpa.gov.tw/educZone/edu_detail.aspx?CatId=21983');


insert into knowledgecard(knowledgeCardId, beginningPeriod, content, endPeriod, reference, title, url)
values(29, '0','以正向語句替代負面詞彙，換個說法增進親子關係。',
'36', '<用愛教出快樂的孩子-0-6歲正向教養手冊>', '說正向的話','https://health99.hpa.gov.tw/educZone/edu_detail.aspx?CatId=21983');

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('R', 1);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('N', 2);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('R', 3);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('S', 4);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('N', 5);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('Q', 6);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 7);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('P', 7);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('T', 8);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('S', 9);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('N', 10);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('P', 11);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('T', 12);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 13);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 14);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('P', 14);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 14);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 15);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('N', 16);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 17);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 18);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 19);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('T', 20);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('S', 21);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('S', 22);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 23);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 24);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 25);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('M', 26);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('T', 27);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('T', 28);

insert into knowledgecardandissuetag(issueTagId, knowledgeCardId)
values('U', 29);