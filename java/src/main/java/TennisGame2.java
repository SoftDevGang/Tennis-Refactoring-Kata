public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = ""; // mutated
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
        if (P1point==P2point && P1point>=3)
            score = "Deuce";
        
        if (P1point > 0 && P2point==0)
        {
            score = getScoreLovePlayer2();
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreLovePlayer2() {
        Output r = pureGetScoreLovePlayer2(P1point, P1res, P2res); 
        
        P1res = r.r1; 
        P2res = r.r2; 
        
        return r.score;
    }

    static class Output {
        String r1;
        String r2;
        String score;
    }
    
    // win: we have 3 pure functions which we can move around and change as we like.
    
    private static Output pureGetScoreLovePlayer2(int pointsPlayer1, 
                String defaultScorePlayer1, String defaultScorePlayer2) {
        String scoreNamePlayer1 = scorePlayer1(defaultScorePlayer1, pointsPlayer1);
        String scoreNamePlayer2 = lovePlayer2(defaultScorePlayer2);
        String score = namedScoreBothPlayers(scoreNamePlayer1, scoreNamePlayer2);
        
        Output result = new Output();
        result.r1 = scoreNamePlayer1; 
        result.r2 = scoreNamePlayer2; 
        result.score = score;
        
        return result;
    }

    private static String namedScoreBothPlayers(String p1, String p2) {
        return p1 + "-" + p2;
    }

    private static String scorePlayer1(String oldP1Res, int p1p) {
        String newP1Res = oldP1Res;
        if (p1p==1)
            newP1Res = "Fifteen";
        if (p1p==2)
            newP1Res = "Thirty";
        if (p1p==3)
            newP1Res = "Forty";
        return newP1Res;
    }

    private static String lovePlayer2(String oldP2Res) {
        return "Love";
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}