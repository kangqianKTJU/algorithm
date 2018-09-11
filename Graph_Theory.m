%% �ж�ͼ�пɴ����ʵ��
% �ڽӾ���
A = [0,1,1,1
    1,0,1,1
    1,1,0,1
    1,1,1,0];
% �ɴ����
P = A;
 n = length(A);
 for i=2:n
     P = P + A^i;
 end
 % ����Ϊ0��Ԫ����Ϊ0�����ɴ�
 P(P~=0)=1;
 P
 
 %% ���·���⡪���Ͽ�˹�����㷨��Dijkstra)
 clc;
 clear;
 % �ڽӾ���
a = [0 50 inf 40 25 10
     50 0 15 20 inf 15
     inf 15 0 10 20 inf
     40 20 10 0 10 25
     25 inf 20 10 0 55
     10 25 inf 25 55 0];


n = length(a);      % �������
short_index = zeros(1,n);   % ��ȷ�����·���Ķ��㣬1��ʾ�Ѿ�ȷ��
startPoint = 1;     % Ҫȷ����·������ʼ��
distance = a(startPoint,:); % ��ʼ�㵽�������̾���
temp_distance = distance; % ��ʱ�����̾��룬ÿ���ҵ���̾��뽫����inf,������������̾���

short_index(startPoint) = 1; 
temp_distance(startPoint) = inf;
route = zeros(n); % ��¼·������
route(:,1) = startPoint;

i = 2; % ��¼·���ĵ�������
while sum(short_index) < n
    [x, minIndex] = min(temp_distance); % �ҵ���̾�������
    route(minIndex,i) = minIndex;   % ���������д��·������
    short_index(minIndex) = 1; 
    temp_distance(minIndex) = inf;
    index = find(distance > distance(minIndex)+ a(minIndex,:)); % ��¼����Сֵ�ı������
    route(index,i)=minIndex;
    i=i+1;
    distance= min(distance,distance(minIndex)+ a(minIndex,:));
    temp_distance = distance;  
end
distance
route

%% ����ͼ���·�Ĺ滮ģ��
% �ڽӾ���
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

 








