#define endl '\n'

class Solution {
private:
    static constexpr int8_t d[] = {0, 1, 0, -1, 0};

    inline uint32_t pack(const uint8_t& i, const uint8_t& j, const int& h) { return (h << 16) | (static_cast<uint16_t>(i) << 8) | j; }
public:
    int swimInWater(vector<vector<int>>& grid) {
        const uint8_t n = grid.size();
        bool* pushed = (bool*)calloc(n * n, sizeof(bool));

        uint8_t i = 0, j = 0;

        priority_queue<uint32_t, vector<uint32_t>, greater<uint32_t>> q;
        q.push(pack(i, j, grid[i][j]));
        pushed[0] = true;

        int mx = grid[i][j];
        while (i != n - 1 || j != n - 1) {
            const uint32_t &t = q.top();
            i = (t >> 8) & 0xFF;
            j = t & 0xFF;
            mx = max(mx, grid[i][j]);
            q.pop();

            for (uint8_t idx = 0; idx < 4; idx++) {
                const uint8_t ni = i + d[idx], nj = j + d[idx + 1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !pushed[nj + ni * n]) {
                    q.push(pack(ni, nj, grid[ni][nj]));
                    pushed[nj + ni * n] = true;
                }
            }
        }

        free(pushed);
        return mx;
    }
};

static const bool init = []() {
    cin.tie(nullptr);
    cout.tie(nullptr);
    return ios_base::sync_with_stdio(false);
}();