package com.example.mainactivity.data.datasource.local_source;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mainactivity.classes.Caracter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CaracterDao_Impl implements CaracterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Caracter> __insertionAdapterOfCaracter;

  private final EntityDeletionOrUpdateAdapter<Caracter> __deletionAdapterOfCaracter;

  private final EntityDeletionOrUpdateAdapter<Caracter> __updateAdapterOfCaracter;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CaracterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCaracter = new EntityInsertionAdapter<Caracter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Caracter` (`id`,`name`,`species`,`status`,`gender`,`image`,`episodes`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Caracter value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSpecies() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSpecies());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        stmt.bindLong(7, value.getEpisodes());
      }
    };
    this.__deletionAdapterOfCaracter = new EntityDeletionOrUpdateAdapter<Caracter>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Caracter` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Caracter value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCaracter = new EntityDeletionOrUpdateAdapter<Caracter>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Caracter` SET `id` = ?,`name` = ?,`species` = ?,`status` = ?,`gender` = ?,`image` = ?,`episodes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Caracter value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSpecies() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSpecies());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        stmt.bindLong(7, value.getEpisodes());
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Caracter";
        return _query;
      }
    };
  }

  @Override
  public Object insertCharacter(final Caracter caracter,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCaracter.insert(caracter);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteCharacter(final Caracter caracter,
      final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfCaracter.handle(caracter);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateCharacter(final Caracter caracter,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCaracter.handle(caracter);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getCaracters(final Continuation<? super List<Caracter>> continuation) {
    final String _sql = "Select * from caracter";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Caracter>>() {
      @Override
      public List<Caracter> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSpecies = CursorUtil.getColumnIndexOrThrow(_cursor, "species");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final List<Caracter> _result = new ArrayList<Caracter>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Caracter _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSpecies;
            if (_cursor.isNull(_cursorIndexOfSpecies)) {
              _tmpSpecies = null;
            } else {
              _tmpSpecies = _cursor.getString(_cursorIndexOfSpecies);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final int _tmpEpisodes;
            _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            _item = new Caracter(_tmpId,_tmpName,_tmpSpecies,_tmpStatus,_tmpGender,_tmpImage,_tmpEpisodes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getCaracter(final int caracterId,
      final Continuation<? super Caracter> continuation) {
    final String _sql = "Select * from caracter where caracter.id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, caracterId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Caracter>() {
      @Override
      public Caracter call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSpecies = CursorUtil.getColumnIndexOrThrow(_cursor, "species");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfEpisodes = CursorUtil.getColumnIndexOrThrow(_cursor, "episodes");
          final Caracter _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSpecies;
            if (_cursor.isNull(_cursorIndexOfSpecies)) {
              _tmpSpecies = null;
            } else {
              _tmpSpecies = _cursor.getString(_cursorIndexOfSpecies);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final int _tmpEpisodes;
            _tmpEpisodes = _cursor.getInt(_cursorIndexOfEpisodes);
            _result = new Caracter(_tmpId,_tmpName,_tmpSpecies,_tmpStatus,_tmpGender,_tmpImage,_tmpEpisodes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
