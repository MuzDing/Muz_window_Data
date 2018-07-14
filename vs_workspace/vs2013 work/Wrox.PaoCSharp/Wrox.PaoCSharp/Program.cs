using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Wrox.PaoCSharp
{
    public interface YBankAccount
    {
        void PayIn(decimal amount);
        bool WithhDraw(decimal amount);
        decimal Balance { get; }
    }
}
