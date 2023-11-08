package Model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncDAO {
    ConexaoDAO dao = new ConexaoDAO();
    Connection conn = dao.connectionDAO();

    public ResultSet getFunc(String name) {
        try {
            String sql = "Select * from tb_funcs join aulajava.tb_cargos tc on tb_funcs.cd_cargos = tc.cd_cargos where nome_func LIKE ?";
            PreparedStatement pstm = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            pstm.setString(1, "%" + name + "%");
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return null;
        }
    }
}
