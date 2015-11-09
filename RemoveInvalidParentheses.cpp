class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> res;
        unordered_map<string, int> visit;
        queue<string> q;
        q.push(s);
        ++visit[s];
        bool find = false;
        while(!q.empty()) {
            s = q.front(); q.pop();
            if(isValid(s)) {
                res.push_back(s);
                find = true;
            }
            if(find) continue;
            for(int i = 0; i < s.size(); ++i) {
                if(s[i] != '(' && s[i] != ')') continue;
                string newstr = s.substr(0, i) + s.substr(i + 1);
                if(visit.find(newstr) == visit.end()) {
                    q.push(newstr);
                    ++visit[newstr];
                }
            }
        }
        return res;
    }
    bool isValid(string s) {
        int ch = 0;
        for(int i = 0; i < s.size(); ++i) {
            if(s[i] == '(') ++ch;
            if(s[i] == ')' && ch-- == 0) return false;
        }
        return ch == 0;
    }
};