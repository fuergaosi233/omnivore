package app.omnivore.omnivore.persistence.entities

import androidx.room.*
import app.omnivore.omnivore.persistence.BaseDao

@Entity
data class Viewer(
  @PrimaryKey val userID: String,
  val name: String,
  val username: String,
  val profileImageURL: String?,
  val intercomHash: String?,
)

@Dao
interface ViewerDao {
  @Query("SELECT * FROM viewer")
  fun getAll(): List<Viewer>

  @Query("SELECT * FROM viewer WHERE userID IN (:viewerIds)")
  fun loadAllByIds(viewerIds: IntArray): List<Viewer>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(vararg viewers: Viewer)

  @Delete
  fun delete(viewer: Viewer)
}
