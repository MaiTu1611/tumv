using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace CNF
{
    public partial class FrCNF : Form
    {
        public FrCNF()
        {
            InitializeComponent();
            
        }
        private void FrCNF_Load(object sender, EventArgs e)
        {
            ImportContextTest();
            txtTest.Text = ("Nam học bài");
            txtTest.Enabled = false;
            txtGrammar.Hide();
            
        }
        public class Rule
        {
            public string left;
            public string[] right;
            public int lengthRight;
            public Rule(string l, string[] r)
            {
                left = l; right = r;
                lengthRight = r.Length;
            }
        }

        List<Rule> Rules;
        string[,] table;
        string[] s1;
        private void ImportContextTest()
        {
            try
            {
                FileStream file = new FileStream("Sentences.txt", FileMode.Open);
                StreamReader read = new StreamReader(file);
                string line;
                while ((line = read.ReadLine()) != null)
                {
                    txtTest.Items.Add(line);
                }
            }
            catch
            {
                txtTreeBank.Text = "Lỗi đọc File!";
            }
        }
        private void ImportTreeBank()
        {
            try
            {
                FileStream file = new FileStream("Treebank.txt", FileMode.OpenOrCreate);
                StreamReader read = new StreamReader(file);
                string line;
                while ((line = read.ReadLine()) != null)
                {
                    txtTreeBank.AppendText(line + "\n");
                }
            }
            catch
            {
                txtTreeBank.Text = "Lỗi đọc File!";
            }
           
        }
        
        private void bt1_Click(object sender, EventArgs e)
        {
            Rules = new List<Rule>();
            string S = txtTest.Text;
            S = S.ToUpper();
            string[] gram = txtGrammar.Lines;
            string[] Sen = S.Split(' ');

            int a = gram.Length;

            //Lấy các rules từ grammar
            for (int i = 0; i < a; i++)
                split_gram(gram[i]);

            int b = Sen.Length;//so tu trong cau

            table = null;
            table = new string[b + 1, b + 1];

            //gan terminal vao duong cheo

            //Thực hiện PCKY
            for (int k = 1; k <= b; k++)
            {
                
                //điền vào đường chéo
                Prob_Ter(Sen[k - 1], k);

                if (k > 1)
                {
                    NonTer(table[k - 1, k], k - 1, k);
                }
                   
            }

            //xử lý S
            txtOut.Clear();
            if (table[0, b] != null)
            {
                string[] kq = table[0, b].Split('\n');
                if (kq[0] == "S")
                {
                    txtOut.AppendText("CAU DUNG CU PHAP.\n");
                    for (int i = 0; i < b - 1; i++)
                    {
                        string sTable = table[i, i + 1];
                        if (sTable != null)
                        {
                            txtOut.AppendText(sTable + "\n");
                        }
                    }
                    for (int i = b - 1; i > 0; i--)
                    {
                        string sTable = table[i, b];
                        if (sTable != null)
                        {
                            txtOut.AppendText(sTable + "\n");
                        }
                    }
                    txtOut.AppendText(table[0, b] + "\n");

                    string[] textAreaOut = txtOut.Lines;
                    int lengthArray = textAreaOut.Length / 3; // 3 : vi tri p = x

                    List<string> arrStringP = new List<string>();
                    for (int i = 1; i <= lengthArray; i++)
                    {
                        arrStringP.Add(textAreaOut[3*i]);
                    }
                    List<string> arrP = new List<string>();
                    foreach (string s in arrStringP)
                    {
                        string[] tmp = s.Split(' ');
                        arrP.Add(tmp[2]);
                    }

                    //Tinh sac suat ca cau
                    double result = 1;
                    foreach (string s in arrP)
                    {
                        double tmp = Convert.ToDouble(s);
                        result = calculatorP(result, tmp);
                    }
                    txtOut.AppendText("\n");
                    txtOut.AppendText("== XAC SUAT ==\n");
                    txtOut.AppendText("P = ");
                    int lengthTmp = textAreaOut.Length;
                    for (int i = 1; i < lengthTmp - 3; i += 3)
                    {
                        if (i == textAreaOut.Length - 4)
                        {
                            txtOut.AppendText("P | " + textAreaOut[i] + "\n");
                        }
                        else
                        {
                            txtOut.AppendText("P | " + textAreaOut[i] + " * ");
                        }
                    }
                    txtOut.AppendText("= " + result.ToString());
                }
                else
                    txtOut.AppendText("Câu không đúng cú pháp.");
            }
            else
                txtOut.AppendText("Câu không đúng cú pháp.");
   
            //fill table lên Datagridview          
            Table2.RowHeadersVisible = false;//Ẩn rowheader
            Table2.DefaultCellStyle.WrapMode = DataGridViewTriState.True;
            Table2.Columns.Clear();
            Table2.Rows.Clear();
            for (int i = 0; i < b; i++)
            {
                Table2.Columns.Add(Sen[i], i + 1 + "\n" + Sen[i]);
            }
            for (int k = 0; k < b; k++)
            {
                String[] cols = new String[b+1];
                for (int i = 1; i <= b; i++)
                {
                    if (table[k, i] == null) table[k, i] = "-";
                    {
                        cols[i - 1] = table[k, i];
                    }
                }
                Table2.Rows.Add(cols);
            }           
        }    
        //Tạo grammar từ treebank
        public void CreateGram()
        {
            //Đọc treebank để lấy grammar
            for (int i = 0; i < txtTreeBank.Lines.Count(); i++)
            {
                s1 = txtTreeBank.Lines[i].Split(' ');
                for (int j = 0; j < s1.Length; j++)
                {
                    if (s1[j] == "(")
                    {
                        GetRule(s1[j + 1], j + 1);
                    }
                }
            }
            List<int> countRule = new List<int>();
            string[] Grammar = txtGrammar.Lines;
            string[] ruleGrammar = txtGrammar.Lines;
            for (int i = 0; i < Grammar.Length-1; i++)
            {
                int count = 1;
                for (int j = i+1; j < Grammar.Length; j++)
                {
                    if (CheckGram(Grammar[i], Grammar[j]))
                    {
                        count++;
                        Grammar[j] = "";
                    }

                    if (Grammar[j] == "S -> NP NP")
                    {
                        Grammar[j] = "";
                        count++;
                    }
                }
                countRule.Add(count);
            }
            txtGrammar.Clear();
            for (int i = 0; i < Grammar.Length; i++)
            {
                if (Grammar[i] != "") txtRule.AppendText(countRule[i] + " " + Grammar[i] + "\n");
                txtGrammar.AppendText(ruleGrammar[i] + "\n");
            }  
        }

        // grammar từ TreeBank
        public void GetRule(string c1, int i)
        {
            if (s1[i + 1] == "(")
            {
                txtGrammar.AppendText(s1[i] + " -> " + s1[i + 2]);
                for (int j = i + 2; j < s1.Length; j++)
                {
                    if (s1[j] == "(")
                    {
                        txtGrammar.AppendText(" " + s1[j + 1]);
                        txtGrammar.AppendText("\n"); 
                        break;       
                    }
                }
            }else
            {
                txtGrammar.AppendText(s1[i] + " -> " + s1[i + 1]);
                txtGrammar.AppendText("\n"); 
            }
            
        }

        //Xử lý các rule trong grammar
        public void split_gram(string gram)
        {
            string[] arr = gram.Split(' ');
            if (arr.Length == 3)
            {
                string[] right = { arr[2] };
                Rules.Add(new Rule(arr[0], right));
            }
            if (arr.Length == 4)
            {
                string[] right = { arr[2], arr[3] };
                Rules.Add(new Rule(arr[0], right));
            }
        }

        //Kiểm tra 2 rul trùng nhau
        public Boolean CheckGram(string g1, string g2)
        {
            if (g1 == g2) return true;
            return false;
        }

        //xử lý probter
       public void Prob_Ter(string Word, int i)
        {
            foreach (Rule r in Rules)
            {
                if (r.lengthRight == 1)//xet luat X -> word
                {
                    if (r.right[0] == Word)
                    {
                        table[i - 1, i] = r.left + "\n(" + (i-1) + "," + i + ")" +"\nP = " + PRule(r);
                        break;
                    }
                }
            }
        }
        //Xử lý Nonter
        
        public void NonTer(string Word, int h, int k)
       {
           try
           {
               string[] st2 = Word.Split('\n');
              
               Word = st2[0];
               bool tN = false;
               for (int i = h - 1; i >= 0; i--)
               {
                   for (int j = i + 1; j <= k - 1; j++)
                   {
                       foreach (Rule rl in Rules)
                           if (table[i, j] != null)
                               if (rl.lengthRight == 2)
                               {
                                   string[] st = table[i, j].Split('\n');
                                   if (rl.right[0] == st[0] && rl.right[1] == Word)
                                   {
                                       
                                       table[i, k] = rl.left + "\n(" + i + "," + j + ")" + " + (" + j + "," + k + ")\nP = " + pTree(rl);
                                       Word = rl.left;
                                       tN = true;
                                       break;
                                   }
                               }
                       if (tN) break;
                   }
               }
           }
           catch (Exception ex)
           {
               MessageBox.Show("Vui long kiem tra lai.");
               //MessageBox.Show(StackTrace(ex, true));
           }
       }
        private double calculatorP(double x, double y)
        {
            return x * y;
        }
        private double pTree(Rule r)
        {
            double PofR;
            double tu = 0;
            double mau = 0;
            foreach (Rule rl in Rules)
            {

                if (rl.left == r.left)
                {
                    mau++;
                }
            }

            foreach (Rule rr in Rules)
            {
                if (rr.left == r.left && rr.right[0] == r.right[0] && rr.right[1] == r.right[1])
                {
                    tu++;
                }
            }

            return Math.Round(PofR = tu / mau, 4);
        }
        //Tính xác suất của rule
        private double PRule(Rule r)
        {
            double PofR;
            double tu = 0;
            double mau = 0;
            foreach (Rule rl in Rules)
            {
                
                if (rl.left == r.left) {
                    mau++;
                }
            }
            
            foreach (Rule rr in Rules)
            {
                if (rr.left == r.left && rr.right[0] == r.right[0])
                {
                    tu++;
                }
            }
            
            return Math.Round(PofR = tu / mau, 4);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            OpenFileDialog theDialog = new OpenFileDialog();
            theDialog.Title = "Open Text File";
            theDialog.Filter = "TXT files|*.txt";
            if (theDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    txtTreeBank.Clear();
                    FileStream file = new FileStream(theDialog.FileName.ToString(), FileMode.Open);
                    StreamReader read = new StreamReader(file);
                    string line;
                    while ((line = read.ReadLine()) != null)
                    {
                        
                        txtTreeBank.AppendText(line + "\n");
                    }
                    file.Close();
                }
                catch
                {
                    txtTreeBank.Text = "Lỗi đọc File!";
                }
            }
            CreateGram();
            txtTest.Enabled = true;
        }

        private void txtTest_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                if (txtTest.Text != null)
                {

                    {
                        Rules = new List<Rule>();
                        string S = txtTest.Text;
                        S = S.ToUpper();
                        string[] gram = txtGrammar.Lines;
                        string[] Sen = S.Split(' ');

                        int a = gram.Length;

                        //Lấy các rules từ grammar
                        for (int i = 0; i < a; i++)
                            split_gram(gram[i]);

                        int b = Sen.Length;//so tu trong cau

                        table = null;
                        table = new string[b + 1, b + 1];

                        //gan terminal vao duong cheo

                        //Thực hiện PCKY
                        for (int k = 1; k <= b; k++)
                        {

                            //điền vào đường chéo
                            Prob_Ter(Sen[k - 1], k);

                            if (k > 1)
                            {
                                NonTer(table[k - 1, k], k - 1, k);
                            }

                        }

                        //xử lý S
                        txtOut.Clear();
                        if (table[0, b] != null)
                        {
                            string[] kq = table[0, b].Split('\n');
                            if (kq[0] == "S")
                            {
                                txtOut.AppendText("CAU DUNG CU PHAP.\n");
                                for (int i = 0; i < b - 1; i++)
                                {
                                    string sTable = table[i, i + 1];
                                    if (sTable != null)
                                    {
                                        txtOut.AppendText(sTable + "\n");
                                    }
                                }
                                for (int i = b - 1; i > 0; i--)
                                {
                                    string sTable = table[i, b];
                                    if (sTable != null)
                                    {
                                        txtOut.AppendText(sTable + "\n");
                                    }
                                }
                                txtOut.AppendText(table[0, b] + "\n");

                                string[] textAreaOut = txtOut.Lines;
                                int lengthArray = textAreaOut.Length / 3; // 3 : vi tri p = x

                                List<string> arrStringP = new List<string>();
                                for (int i = 1; i <= lengthArray; i++)
                                {
                                    arrStringP.Add(textAreaOut[3 * i]);
                                }
                                List<string> arrP = new List<string>();
                                foreach (string s in arrStringP)
                                {
                                    string[] tmp = s.Split(' ');
                                    arrP.Add(tmp[2]);
                                }

                                //Tinh sac suat ca cau
                                double result = 1;
                                foreach (string s in arrP)
                                {
                                    double tmp = Convert.ToDouble(s);
                                    result = calculatorP(result, tmp);
                                }
                                txtOut.AppendText("\n");
                                txtOut.AppendText("== XAC SUAT ==\n");
                                txtOut.AppendText("P = ");
                                int lengthTmp = textAreaOut.Length;
                                for (int i = 1; i < lengthTmp - 3; i += 3)
                                {
                                    if (i == textAreaOut.Length - 4)
                                    {
                                        txtOut.AppendText("P | " + textAreaOut[i] + "\n");
                                    }
                                    else
                                    {
                                        txtOut.AppendText("P | " + textAreaOut[i] + " * ");
                                    }
                                }
                                txtOut.AppendText("= " + result.ToString());
                            }
                            else
                                txtOut.AppendText("Câu không đúng cú pháp.");
                        }
                        else
                            txtOut.AppendText("Câu không đúng cú pháp.");

                        //fill table lên Datagridview          
                        Table2.RowHeadersVisible = false;//Ẩn rowheader
                        Table2.DefaultCellStyle.WrapMode = DataGridViewTriState.True;
                        Table2.Columns.Clear();
                        Table2.Rows.Clear();
                        for (int i = 0; i < b; i++)
                        {
                            Table2.Columns.Add(Sen[i], i + 1 + "\n" + Sen[i]);
                        }
                        for (int k = 0; k < b; k++)
                        {
                            String[] cols = new String[b + 1];
                            for (int i = 1; i <= b; i++)
                            {
                                if (table[k, i] == null) table[k, i] = "-";
                                {
                                    cols[i - 1] = table[k, i];
                                }
                            }
                            Table2.Rows.Add(cols);
                        }
                    }        
                }
            }
        }
    }
}
