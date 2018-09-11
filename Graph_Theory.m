%% 判断图中可达与否实列
% 邻接矩阵
A = [0,1,1,1
    1,0,1,1
    1,1,0,1
    1,1,1,0];
% 可达矩阵
P = A;
 n = length(A);
 for i=2:n
     P = P + A^i;
 end
 % 将不为0的元素置为0，即可达
 P(P~=0)=1;
 P
 
 %% 最短路问题——迪克斯特拉算法（Dijkstra)
 clc;
 clear;
 % 邻接矩阵
a = [0 50 inf 40 25 10
     50 0 15 20 inf 15
     inf 15 0 10 20 inf
     40 20 10 0 10 25
     25 inf 20 10 0 55
     10 25 inf 25 55 0];


n = length(a);      % 顶点个数
short_index = zeros(1,n);   % 已确定最短路径的顶点，1表示已经确定
startPoint = 1;     % 要确定的路径的起始点
distance = a(startPoint,:); % 起始点到各点的最短距离
temp_distance = distance; % 暂时存放最短距离，每次找到最短距离将其置inf,方便下轮找最短距离

short_index(startPoint) = 1; 
temp_distance(startPoint) = inf;
route = zeros(n); % 记录路径矩阵
route(:,1) = startPoint;

i = 2; % 记录路径的迭代次数
while sum(short_index) < n
    [x, minIndex] = min(temp_distance); % 找到最短距离索引
    route(minIndex,i) = minIndex;   % 将最短索引写入路径矩阵
    short_index(minIndex) = 1; 
    temp_distance(minIndex) = inf;
    index = find(distance > distance(minIndex)+ a(minIndex,:)); % 记录下最小值改变的索引
    route(index,i)=minIndex;
    i=i+1;
    distance= min(distance,distance(minIndex)+ a(minIndex,:));
    temp_distance = distance;  
end
distance
route

%% 有向图最短路的规划模型
% 邻接矩阵
clc;
clear;
n = 7;
c = [2,4,3,3,1,2,3,1,1,3,4];
m = length(c)
Aeq = zeros(n,m);
Aeq(1,1:2) = 1;
Aeq(2,3:5) = 1;
Aeq(2,1) = -1;
Aeq(3,6:8) = 1;
Aeq(3,2) = -1;
Aeq(4,9) = 1;
Aeq(4,3:4) = -1;
Aeq(5,10) = 1;
Aeq(5,[4 6]) = -1;
Aeq(6,11) = 1;
Aeq(6,7:8) = -1;
Aeq(7,9:11) = -1;
beq = zeros(1,n);
beq(1) = 1;
beq(n) = -1;
intcon = 1:m;
lb = zeros(1,m);
ub = ones(1,m);

result = intlinprog(c,intcon,[],[],Aeq,beq,lb,ub)

%%

 








